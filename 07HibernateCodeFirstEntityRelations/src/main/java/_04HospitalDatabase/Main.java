//package _04HospitalDatabase;
//
//import com.sun.org.apache.bcel.internal.generic.NEW;
//import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializerWithPrefixMapping;
//import org.apache.commons.io.FileUtils;
//import sun.invoke.empty.Empty;
//
//import javax.persistence.Column;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.io.File;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//import java.util.Set;
//
///**
// * Created by IntelliJ IDEA.
// * User: LAPD
// * Date: 28.3.2018 г.
// * Time: 18:06 ч.
// */
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Choose option:");
//            System.out.println("[S]earch or [A]dd? [E]xit");
//
//            String firstOption = console.nextLine().toUpperCase();
//
//            switch (firstOption) {
//                case "S":
//                case "A":
//                    SecondOption(firstOption);
//                    break;
//                case "E":
//                    return;
//                default:
//                    System.out.println("Wrong input!");
//                    continue;
//            }
//
//
//        }
//    }
//
//    private static void SecondOption(String firstOption) {
//        Scanner console = new Scanner(System.in);
//
//        while (true) {
//
//            if (firstOption == "A")
//                System.out.println("Enter ADD option: [E]xit");
//            else
//                System.out.println("Enter SEARCH option: [E]xit");
//
//            System.out.println("Patient [I]nfo");
//            System.out.println("Patient [V]isitation");
//            System.out.println("[D]iagnose");
//            System.out.println("[M]edicament");
//
//            String firstAndSecondOption = firstOption
//                    + console.nextLine().toUpperCase();
//
//            switch (firstAndSecondOption) {
//                case "AI":
//                    AddPatientInfo();
//                    break;
//                case "AV":
//                    break;
//                case "AD":
//                    break;
//                case "AM":
//                    break;
//                case "SI":
//                    break;
//                case "SV":
//                    break;
//                case "SD":
//                    break;
//                case "SM":
//                    break;
//                case "AE":
//                case "SE":
//                    return;
//                default:
//                    System.out.println("Wrong input!");
//                    continue;
//            }
//        }
//    }
//
//    private static void AddPatientInfo() {
//        Scanner console = new Scanner(System.in);
//
//        System.out.println("Enter patient first name:");
//        String firstName = console.nextLine();
//
//        System.out.println("Enter patient last name:");
//        String lastName = console.nextLine();
//
//        System.out.println("Enter patient address:[ENTER for none]");
//        String address = console.nextLine();
//
//        System.out.println("Enter patient email:[ENTER for none]");
//        String email = console.nextLine();
//
//        Date DOB;
//        while (true) {
//            try {
//                System.out.println("Enter patient date of birth:[YYYY-MM-DD]");
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//                DOB = formatter.parse(console.nextLine());
//            } catch (ParseException e) {
//                System.out.println("Wrong input!");
//                continue;
//            }
//            break;
//        }
//
//        byte[] picture;
//        while (true) {
//            System.out.println("Enter patient picture path:[ENTER for none]");
//            String path = console.nextLine();
//
//            try {
//                if (path.isEmpty()) {
//                    picture = null;
//                    break;
//                }
//
//                picture = FileUtils
//                        .readFileToString(new File(path))
//                        .getBytes();
//            } catch (IOException e) {
//                System.out.println("Wrong input!");
//                continue;
//            }
//            break;
//        }
//
//        boolean hasMedicalInsurance;
//        while (true) {
//            System.out.println("Available medical insurance? [Y] or [N]");
//            switch (console.nextLine().toUpperCase()) {
//                case "Y":
//                    hasMedicalInsurance = true;
//                    break;
//                case "N":
//                    hasMedicalInsurance = false;
//                    break;
//                default:
//                    System.out.println("Wrong input!");
//                    continue;
//            }
//            break;
//        }
//
//        Patient newPatient = new Patient(firstName, lastName,
//                address, email, DOB, picture, hasMedicalInsurance);
//
//        UpdateDatabase(newPatient);
//    }
//
//    private static void UpdateDatabase(Object currentObject) {
//
//        EntityManagerFactory emf = Persistence
//                .createEntityManagerFactory("CodeFirst");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//
//            em.persist(currentObject);
//
//            em.getTransaction().commit();
//
//            System.out.println("Successfully added!");
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//            emf.close();
//        }
//    }
//}
