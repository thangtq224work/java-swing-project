/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Thang
 */
public class XImage {
    public static Image getImage(){
        URL u = XImage.class.getResource("/icons/fpt.png");
        ImageIcon icon = new ImageIcon(u);
        return icon.getImage();
    }
    public static void save(File src){
        File f = new File("images", src.getName());
        System.out.println(src.getName());
        if(f.getParentFile().exists() == false){
            f.getParentFile().mkdirs();
            // mkdirs() sẽ tạo đường dẫn theo chỉ định còn mkdir() chỉ tạo đường dẫn khi đường dẫn cha của nó tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(f.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    public static ImageIcon read(String fileName){
        File f = new File("images",fileName);
        return new ImageIcon(f.getAbsolutePath());
    }
}
