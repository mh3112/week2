package MVC.Controllers;

import MVC.Models.StudentModels;
import MVC.StudentVO;

import java.io.IOException;
import java.util.Vector;

/**
 * Created by Minh Hang on 09/27/2016.
 */

/*
Nhận dữ liệu từ View và chuyển cho Model xử lý,
sau khi Model xử lý sẽ trả kết quả về cho Controller
và Controller sẽ trả kết quả về cho View hiển thị lên giao diện.
 */


public class StudentControllers {
    StudentModels sm = new StudentModels();

    public void InsertWithKeyboard() throws IOException {
        try {
            sm.Keyboard();
        } catch (Exception e) {

        }
    }

    public void InsertWithPath(String str) throws IOException {
        try {
            sm.WithPath(str);
        } catch (Exception e) {
        }
    }

    public Vector<StudentVO> Recent_List() {
        return sm.StList();
    }

    public void Delete() {
        try {
            sm.DeleteStudent();
        } catch (Exception e) {
        }
    }

    public void FixStudent(String s) {
        try {
            sm.FixSt(s);
        } catch (Exception e) {
        }
    }

    public void SearchStudent(int ch) {
        try {
            sm.SearchSt(ch);
        } catch (Exception e) {
        }
    }

    public Vector<StudentVO> SortList(int ch) throws IOException{
        return sm.SortSt(ch);
    }

    public void Statistic(){
        try {
            sm.StatisticSt();
        } catch (Exception e) {
        }
    }

}
