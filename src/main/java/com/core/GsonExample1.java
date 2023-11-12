package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.*;

public class GsonExample1 {

    public static void main(String[] args) {

        // pretty print
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
                .create();

        ArrayList<Staff> staffs = createStaffObject();

        // Java objects to String
        String json = gson.toJson(staffs);

        //System.out.println(json);

        // Java objects to File
        try (FileWriter writer = new FileWriter("C://Users/лиза/Desktop/strweb_3/GSON/src/main/resources/student.json")) {
            gson.toJson(staffs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<Staff> createStaffObject() {

        Staff staff = new Staff();
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        ArrayList<Staff> arr = new ArrayList<Staff>();


        staff.setName("Oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "CEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));


        staff1.setName("Oleg1");
        staff1.setAge(351);
        staff1.setPosition(new String[]{"Founder1", "CEO1", "coder1"});
        Map<String, BigDecimal> salary1 = new HashMap() {{
            put("2010", new BigDecimal(100001));
            put("2012", new BigDecimal(120001));
            put("2018", new BigDecimal(140001));
        }};
        staff1.setSalary(salary);
        staff1.setSkills(Arrays.asList("java1", "python1", "node1", "kotlin1"));

        staff2.setName("Lisa");
        staff2.setAge(19);
        staff2.setPosition(new String[]{"Frontend-developer", "CEO", "Backend-developer"});
        HashMap salary2 = new HashMap() {{
            put("2010", new BigDecimal(170000));
            put("2012", new BigDecimal(180001));
            put("2018", new BigDecimal(200001));
        }};
        staff2.setSalary(salary2);
        staff2.setSkills(Arrays.asList("java", "python", "javascript", "kotlin"));

        arr.add(staff);
        arr.add(staff1);
        arr.add(staff2);
        return arr;
    }

}
