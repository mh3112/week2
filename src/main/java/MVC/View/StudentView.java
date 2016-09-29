package MVC.View;

import MVC.Controllers.StudentControllers;
import MVC.StudentVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Minh Hang on 09/27/2016.
 */

/*
Thu thập dữ liệu do người dùng nhập vào
 và chuyển dữ liệu cho Controller và hiển thị kết quả trả về trên giao diện.
 */
public class StudentView {
    StudentControllers stc = new StudentControllers();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);

    private int Menu() {
        System.out.println("##################_Menu_###############");
        System.out.println("1. Add a student");
        System.out.println("2. Display the list");
        System.out.println("3. Delete a student");
        System.out.println("4. Fix formation");
        System.out.println("5. Search a student");
        System.out.println("6. Arrange the list");
        System.out.println("7. Statistic");
        System.out.println("8. Exit");
        System.out.print("=>Enter the number: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void Add() throws IOException {
        //
        System.out.println("1. Add from the keyboard");
        System.out.println("2. Add from the file with path. ");
        System.out.println("3. Back");
        System.out.print("=>Enter the number: ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                stc.InsertWithKeyboard();
                break;
            case 2:
                System.out.println("Enter the path: ");
                String str = br.readLine();
                stc.InsertWithPath(str);
                break;
            default:
                break;
        }
    }

    public void Display() {
        Vector<StudentVO> list = stc.Recent_List();
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("---------------------------------------------");
                System.out.println("====The Student " + (i + 1) + "====");
                System.out.println("ID: " + list.get(i).getId());
                System.out.println("Name: " + list.get(i).getName());
                if (list.get(i).isGender() == true)
                    System.out.println("Gender: Nam");
                else
                    System.out.println("Gender: Nu");
                System.out.println("Address: " + list.get(i).getAddress());
                System.out.println("Date of Birth" + list.get(i).getdOB());
                System.out.println("Math=  " + list.get(i).getMath());
                System.out.println("Physical= " + list.get(i).getPhysic());
                System.out.println("Chemistry= " + list.get(i).getChemis());
                System.out.println("Total= " + list.get(i).getTotal());
            }
        } else
            System.out.println("List is Null!!!");
    }

    public void Search() {
        System.out.println("1. Search by Scores Total ");
        System.out.println("2. Search by ID ");
        System.out.println("3. Search by Name");
        System.out.println("4. Search by Scores(5-Math/6-Physical/7-Chemistry)");
        System.out.print("=>Enter the number: ");
        int ch = sc.nextInt();
        stc.SearchStudent(ch);
    }

    public void Fix() throws IOException {
        System.out.println("Enter the ID of student which you want to fix: ");
        stc.FixStudent(br.readLine());
        System.out.println("Fix is successful!!");
    }


    public void Print(int i, int ch) throws IOException{
        Vector<StudentVO> list=stc.SortList(ch);
        System.out.println("---------------------------------------------");
        System.out.println("====The Student " + (i) + "====");
        System.out.println("ID: " + list.get(i).getId());
        System.out.println("Name: " + list.get(i).getName());
        if (list.get(i).isGender() == true)
            System.out.println("Gender: Nam");
        else
            System.out.println("Gender: Nu");
        System.out.println("Address: " + list.get(i).getAddress());
        System.out.println("Date of Birth" + list.get(i).getdOB());
        System.out.println("Math=  " + list.get(i).getMath());
        System.out.println("Physical= " + list.get(i).getPhysic());
        System.out.println("Chemistry= " + list.get(i).getChemis());
        System.out.println("Total= " + list.get(i).getTotal());
    }

    public void Arrange() throws IOException{

        System.out.println("1. Sort by the ID");
        System.out.println("2. Sort by the Name(Alphabet)");
        System.out.println("3. Sort by the Totals");
        System.out.print("=>Enter the number: ");
        int ch = sc.nextInt();
        for (int i = 0; i < stc.SortList(ch).size(); i++) {
                    Print(i,ch);
                }
    }


    public void MainMenu() throws IOException {
        int menu = Menu();
        while (true) {
            switch (menu) {
                case 1:
                    Add();
                    break;
                case 2:
                    Display();
                    break;
                case 3:
                    stc.Delete();
                    break;
                case 4:
                    Fix();
                    break;
                case 5:
                    Search();
                    break;
                case 6:
                    Arrange();
                    break;
                case 7:
                    stc.Statistic();
                    break;
                case 8:
                    System.exit(1);
                    break;
            }
            menu = Menu();
        }
    }

    public static void main(String[] args) throws IOException {

        StudentView sv = new StudentView();
        sv.MainMenu();


    }
}