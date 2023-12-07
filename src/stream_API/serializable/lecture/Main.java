package stream_API.serializable.lecture;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String str = "Всем привет!";

//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(Character.getName(i));
//        }
//        System.out.println(list);
//        serialObj(list, "ser");
//        list = (ArrayList<String>) deserialObj("ser");
//        System.out.println(list);
//        serialObj(str);

//        MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
//        serialObj(myFCs, "ser");

        MyFCs myFCs1 = (MyFCs) deserialObj("ser");
        System.out.println(myFCs1);
    }

    private static void serialObj(Object o, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    private static Object deserialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

    static class MyFCs implements Serializable {
        public String lName;
        public String fName;
        public String patronymic;

        private static final long serialVersionUID = 1L;

        public MyFCs(String lName, String fName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }
}
