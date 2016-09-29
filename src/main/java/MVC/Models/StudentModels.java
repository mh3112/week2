package MVC.Models;

import MVC.StudentVO;
import MVC.View.StudentView;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import static com.sun.deploy.util.BufferUtil.TB;

/**
 * Created by Minh Hang on 09/27/2016.
 */

//là lớp chứa thông tin đối tượng (Dữ liệu), tương tác với Database. Xử lý dl do Controller chuyển về

public class StudentModels {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    Vector<StudentVO> lst = new Vector<StudentVO>();

    public void Keyboard() throws IOException {
        StudentVO inf = new StudentVO();
        int n;
        System.out.print("Enter N= ");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            inf.Input(i);
            lst.addElement(inf);
        }
    }


    public void WithPath(String str) throws IOException {
        /*
        001|Nguyen A|Ha Noi|Nam|12/1/1996|5|7|8|20
     */

        BufferedReader brd = new BufferedReader(new FileReader(str));
        String sCurrentLine;

        while ((sCurrentLine = brd.readLine()) != null) {
            StudentVO stCurrent = new StudentVO();
            String[] arr = sCurrentLine.split("\\|");
            stCurrent.setId(arr[0]);
            stCurrent.setName(arr[1]);
            stCurrent.setAddress(arr[2]);
            if (arr[3].equals("Nam") || arr[3].equals("nam"))
                stCurrent.setGender(true);
            else if (arr[3].equals("Nu") || arr[3].equals("nu"))
                stCurrent.setGender(false);
            stCurrent.setdOB(arr[4]);
            stCurrent.setMath(Float.parseFloat(arr[5]));
            stCurrent.setPhysic(Float.parseFloat(arr[6]));
            stCurrent.setChemis(Float.parseFloat(arr[7]));
            stCurrent.setTotal(Float.parseFloat(arr[8]));
            lst.addElement(stCurrent);
        }
        System.out.println("Read file is successful!!!");
    }

    public Vector<StudentVO> StList() {
        return lst;
    }

    public void DeleteStudent() {
        if (lst.size() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the ID which you want to delete: ");
            String str = sc.nextLine();
            for (int i = 0; i < lst.size(); i++) {
                if (str.equals(lst.get(i).getId())) {
                    lst.remove(i);
                    System.out.println("Deleted the student have ID= " + str);
                }
            }
        } else
            System.out.println("List is Null!!!");

    }

    public void FixSt(String k) throws IOException {
        {
            StudentVO inf = new StudentVO();
            boolean ch = false;
            for (int i = 0; i < lst.size(); i++) {
                if (lst.get(i).getId().equals(k)) {
                    lst.removeElementAt(i);
                    ch = true;
                    inf.Input(i);
                    lst.add(i, inf);
                }
            }
            if (ch == false)
                System.out.println("The ID is not correct!!!");
        }
    }

    public void WriteToFile(Vector<StudentVO> lst, int i, String filename) throws IOException {
        String str_find;
        String gen;
        if (lst.get(i).isGender() == true)
            gen = "Nam";
        else
            gen = "Nu";
        str_find = lst.get(i).getId() + "|" + lst.get(i).getName() + "|" + lst.get(i).getAddress() + "|" + gen + "|" + lst.get(i).getdOB() + "|"
                + String.valueOf(lst.get(i).getMath()) + "|" + String.valueOf(lst.get(i).getPhysic()) + "|" + String.valueOf(lst.get(i).getChemis())
                + "|" + String.valueOf(lst.get(i).getTotal());
        // WriteToFile(str_find);
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(str_find);
        bw.close();


        System.out.println("===== Write to File successed!!! =====");


    }

    public void SearchSt(int ch) throws IOException {
        String filename = "FindStudent.txt";
        if (lst.size() == 0)
            System.out.println("List is Null!!!");
        else {
            String str;

            Float ft;
            boolean find = false;
            //  int ch = Choice();
            switch (ch) {
                case 1: {
                    System.out.println("Enter the key: ");
                    ft = Float.parseFloat(br.readLine());
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getTotal() == ft) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }

                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;
                }
                case 2:
                    System.out.println("Enter the key: ");
                    str = br.readLine();
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getId().equals(str)) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }
                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    str = br.readLine();
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getName().equals(str)) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }
                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;
                case 5:
                    System.out.println("Enter the key: ");
                    ft = Float.parseFloat(br.readLine());
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getMath() == ft) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }
                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;
                case 6: {
                    System.out.println("Enter the key: ");
                    ft = Float.parseFloat(br.readLine());
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getPhysic() == ft) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }
                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;
                }
                case 7:
                    System.out.println("Enter the key: ");
                    ft = Float.parseFloat(br.readLine());
                    for (int i = 0; i < lst.size(); i++) {
                        if (lst.get(i).getChemis() == ft) {
                            find = true;
                            WriteToFile(lst, i, filename);
                        }
                    }
                    if (find == false)
                        System.out.println("Can not to find!!!");
                    break;
                default:
                    break;
            }
        }

    }


    public Vector<StudentVO> SortSt(int ch) throws IOException {
        Vector<StudentVO> lst_new = new Vector<StudentVO>();
        lst_new = lst;
        switch (ch) {
            case 1:
                Collections.sort(lst_new, new Comparator<StudentVO>() {
                    public int compare(StudentVO o1, StudentVO o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });

                break;
            case 2:
                Collections.sort(lst_new, new Comparator<StudentVO>() {
                    public int compare(StudentVO o1, StudentVO o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });

                break;
            case 3:
                Collections.sort(lst_new, new Comparator<StudentVO>() {
                    public int compare(StudentVO o1, StudentVO o2) {
                        if (o1.getTotal() > o2.getTotal())
                            return 1;
                        else if (o1.getTotal() < o2.getTotal())
                            return -1;
                        else
                            return 0;
                    }
                });
                break;
        }
        return lst_new;
    }

    public void StatisticSt() {
        System.out.println("The size of list student: " + lst.size());
        float TB, Kha, Gioi, XS;
        TB = 0;
        Kha = 0;
        Gioi = 0;
        XS = 0;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getTotal() < 15)
                TB++;
            else if (lst.get(i).getTotal() >= 15 && (lst.get(i).getTotal() < 20))
                Kha++;
            else if (lst.get(i).getTotal() >= 20 && (lst.get(i).getTotal() < 25))
                Gioi++;
            else
                XS++;
        }
        System.out.println("Loai trung binh: " + (int) TB);
        System.out.println("Loai kha: " + (int) Kha);
        System.out.println("Loai gioi: " + (int) Gioi);
        System.out.println("Loai xuat sac: " + (int) XS);
    }

}
