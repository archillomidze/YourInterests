package ge.mziuri.servlet;

import ge.mziuri.dao.ArticleElementDAO;
import ge.mziuri.dao.ArticleElementDAOImpl;
import ge.mziuri.model.ArticleElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet("/Relay")
@MultipartConfig
public class AddaNewArticleElementServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50000 * 1024;
    private int maxMemSize = 50000 * 1024;
    private File file;
    private String imagePath;

    @Override
    public void init() {
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<String> images = new ArrayList<>();
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            Random random = new Random();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String fileName = fi.getName();
                    String extention = FilenameUtils.getExtension(fileName);
                    String imageName = FilenameUtils.removeExtension(fileName);
                    if (fileName.lastIndexOf("\\") >= 0) {
                        fileName = imageName + random.nextInt() + "." + extention;
                        images.add(fileName);
                        imagePath = fileName;
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        fileName = imageName + random.nextInt() + "." + extention;
                        imagePath = fileName;
                        images.add(fileName);
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    try {
                        fi.write(file);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            Map<String, String> table = new HashMap<>();
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.getFieldName().equals("file")) {
                    table.put(item.getFieldName(), item.getString());
                }
            }
            String text = table.get("text");
            ArticleElement articleElement = new ArticleElement();
            List<String> texts = new ArrayList<>();
            texts.add(text);
            articleElement.setTextList(texts);
            articleElement.setPicturesList(images);
            int k=1;
            if (request.getParameter("nextpage") != null) {
                k++;
                articleElement.setIndex(k);
            }
            ArticleElementDAO articleElementDAO = new ArticleElementDAOImpl();
            articleElementDAO.createArticleElement(articleElement, 1);
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("ArticleElement.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
