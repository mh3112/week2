package MVC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Minh Hang on 09/27/2016.
 */
public class StudentVO {
    private String name;
    private String id;
    private String address;
    private boolean gender;
    private String dOB;

    private float math;
    private float physic;
    private float chemis;

    private float total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }


    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getPhysic() {
        return physic;
    }

    public void setPhysic(float physic) {
        this.physic = physic;
    }

    public float getChemis() {
        return chemis;
    }

    public void setChemis(float chemis) {
        this.chemis = chemis;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public StudentVO() {


    }

    public StudentVO(String name, String id, boolean gender, String address, String dOB, Float math, Float physic, Float chemis) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.dOB = dOB;
        this.math = math;
        this.physic = physic;
        this.chemis = chemis;
    }

    public void Input(int i) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--------------------------------------------");
        System.out.println("====The Student " + i + "====");
        System.out.println("Enter the ID: ");
        this.setId(br.readLine());
        System.out.println("Enter the Name: ");
        this.setName(br.readLine());
        System.out.println("Enter the Gender: ");
        String s = br.readLine();
        if (s == "Nam" || s == "nam") {
            this.setGender(true);
        }
        if (s == "Nu" || s == "nu") {
            this.setGender(false);
        }
        System.out.println("Enter the Address: ");
        this.setAddress(br.readLine());
        System.out.println("Enter the Date of Birth: ");
        this.setdOB(br.readLine());
        System.out.println("Enter the Scores:   ");
        System.out.println("Math=  ");
        try {
            this.setMath(Float.parseFloat(br.readLine()));
        } catch (Exception e) {
            System.out.println("Error! Must be enter the number!");
        }
        System.out.println("Physical= ");
        try {
            this.setPhysic(Float.parseFloat(br.readLine()));
        } catch (Exception e) {
            System.out.println("Error! Must be enter the number!");
        }
        System.out.println("Chemistry= ");
        try {
            this.setChemis(Float.parseFloat(br.readLine()));
        } catch (Exception e) {
            System.out.println("Error! Must be enter the number!");
        }
        this.setTotal((this.getMath() + this.getPhysic() + this.getChemis()));
    }

}
