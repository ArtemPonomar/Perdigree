package com.pedigree.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class PedigreeService {

    public void downloadPedigree(long pedigreeId) {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/pedigree?petId=" + pedigreeId);
            String htmlFilePath = "src/main/resources/static/pedigries/" + pedigreeId + ".html";
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(htmlFilePath)));
            File tempFile = File.createTempFile("temp_" + String.valueOf(pedigreeId), "html");
            FileOutputStream out = new FileOutputStream(tempFile);
            IOUtils.copy(new InputStreamReader(url.openStream()), out);
            tempFile.deleteOnExit();
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            reader.close();
            writer.close();
//            htmlToImage(htmlFilePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void htmlToImage(String htmlFilePath) throws IOException {
        try {
            String url = new URL("http://localhost:8080/pedigree?petId=50").toString();
            System.out.println("URL: " + url);

            OutputStream out = new FileOutputStream("src/main/resources/static/pedigries/html.pdf");

            //Flying Saucer part
//            ITextRenderer renderer = new ITextRenderer();
//
//            renderer.setDocument(url);
//            renderer.layout();
//            renderer.createPDF(out);

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (OutputStream os = new FileOutputStream("src/main/resources/static/pedigries/html.pdf")) {
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//            builder.useFastMode();
//            builder.withUri("file://C:/Users/User/Desktop/Perdigree/src/main/resources/static/pedigries/50.html");
//            builder.toStream(os);
//            builder.run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
