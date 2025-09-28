package com.milanbud.filemanager;

import java.io.File;

public class FileManager {

    public void listFiles(String directoryPath){
        File directory = new File(directoryPath);
        if(directory.exists() && directory.isDirectory()){
            File[] contents = directory.listFiles();

            if(contents != null){
                for (File file : contents){
                    if(file.isDirectory()){
                        System.out.println("[DIR]: " + file.getName());
                    }else{
                        System.out.println("[FILE]: " + file.getName());
                    }
                }
            }else{
                System.out.println("Directory is empty.");
            }
        }else{
            System.out.println("That is an invalid directory path: Path either doesn't exist or is not a directory!");
        }
    }


    public String createDirectory(String directoryPath){
        File directory = new File(directoryPath);
        if(directory.mkdir()){
            return "Successfully create directory!";
        }else{
            return "Failed to create directory!";
        }
    }

    public String deleteFileOrDirectory(String directoryOrFilePath){
        File directory = new File(directoryOrFilePath);
        if(directory.delete()){
            return "Successfully deleted the file/directory!";
        }else{
            return "Failed to delete file/directory!";
        }
    }
}
