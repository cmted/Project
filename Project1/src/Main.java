import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class MyException extends Exception {
        private MyException(String str) {
            super(str);
        }
    }

    private static Student[] stu = new Student[10];
    private static int number = 0;

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please follow the format :\t1. update + index_num +name\n"
                + "\t\t\t\t\t\t\t2. create/delete + name\n"
                + "\t\t\t\t\t\t\t3. input get to have the student list ");

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] newStr = input.split("\\s+");
            try {
                if (input.contains("update")) {
                    int a = Integer.parseInt(newStr[1]);
                    update(a, newStr[2]);

                } else if (input.contains("create")) {
                    create(newStr[1]);

                } else if (input.contains("delete")) {
                    delete(newStr[1]);
                } else if (input.contains("get")) {
                    get();
                } else if (input.contains("exit")) {
                    System.exit(0);
                } else {
                    throw new MyException("Wrong input format");
                }

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }


            //输入 add + 空格 +名字 调用 create method
            //输入 update + index + 空格 +名字 调用 update method
            //输入 get 调用 get method, print all students' name
            //输入 delete + 空格 +名字 调用 delete method
            // if else ? switch
            // 确保 不管输入什么值，程序都不会崩溃。 一旦出现错误，给用户友好提示 例如输入 update x jackma ,x 不是数字，就会报错
        }
    }

    public static void create(String name) {  // 创建一个学生，插入进数组。如果数组满了，抛出异常，给用户友好提示。要求根据学生的名字，保证数组有序 升序或者降序
        try {
            if (stu[stu.length - 1] != null) {
                throw new MyException("The array is full");
            } else {
                stu[number] = new Student(name);
                number++;
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(int index, String name) {  // 根据下标 更新 学生名字。如果学生不存在，抛出异常
        try {
            if (stu[index] != null) {
                stu[index] = new Student(name);
            } else {
                throw new MyException("This student does not exist.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void get() {  // 返回数组里面所有学生，打印学生名字。并且保证有序
        Arrays.sort(stu, new Student());
        for (int p = 0; p < stu.length; p++) {
            if (stu[p] != null) {
                System.out.println(stu[p].name);
            }

        }
    }

    public static void delete(String name) { //按名字删除学生，保证数组有序
        try {
            for (int i = 0; i < stu.length; i++) {
                if (stu[i] != null && stu[i].name.equals(name)) {
                    stu[i] = null;
                    break;
                } else if (i == stu.length - 1) {
                    throw new MyException("This student does not exist.");
                }
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }
}
