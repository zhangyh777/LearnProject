package com.zyh.demo.primary.extend_.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        PC pc = new PC("i5",8,1024,"dell");
        NotePad notePad = new NotePad("A10",4,128,"white");
        pc.setBrand("huawei");
        notePad.setCPU("888");
        notePad.setColor("green");
        String pcDetails = pc.getDetails();
        String notePadDetails = notePad.getDetails();
        System.out.println(pcDetails);
        System.out.println(notePadDetails);


    }
}
