package com.milanbud.filemanager;

public class App implements UIEventHandler{
    FileManager fm;
    static UserInterface ui = new TextBasedInterface();

    public App(){
        this.fm = new FileManager();
    }

    static void main() {
        ui.subscribe(new App()); //creating handler instance explicitly from the constructor
        ui.start();
    }

    @Override
    public void onList(String path) {
        this.fm.listFiles(path);
    }

    @Override
    public void onCreate(String path) {
        ui.display(this.fm.createDirectory(path));
    }

    @Override
    public void onDelete(String path) {
        String result = this.fm.deleteFileOrDirectory(path);
        ui.display(result);
    }

}
