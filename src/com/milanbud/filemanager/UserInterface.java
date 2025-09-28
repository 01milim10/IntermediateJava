package com.milanbud.filemanager;

public interface UserInterface {
    public void start();
    public void subscribe(UIEventHandler handler);
    public void display(String message);
}
