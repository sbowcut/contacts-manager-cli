import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

class ContactsManager extends AppMethods {
    public static void main(String[] args) {
        contactListApp(new AppMethods());
    }

    public static void contactListApp(AppMethods in) {
        System.out.println("Main Menu");
        boolean run = true;
        while (run) {
            System.out.println("Please make your selection:");
            System.out.println("1. View Contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search by contact");
            System.out.println("4. Delete contact");
            int userResp = in.getInt("Please enter your selection in the terminal", 1, 4);
            in.getString();
            switch (userResp) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    addContact(in);
                    break;
                case 3:
                    searchByName(in);
                    break;
                case 4:
                    deleteContact(in);
            }
        }
    }

    public static void viewContacts() {
        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (String line : currentList) {
            System.out.println(line);
        }
    }

    public static void addContact(AppMethods in) {
        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        List<String> Contacts = new ArrayList<>();
        String name = in.getString("Please enter the name of the Person:");
        long phoneNumber = in.getInt("Please enter Phone Number:");
        String format = "%1$-30s | %2$-30s";
        String ex[] = {name, Long.toString(phoneNumber)};
        String newContact = format(String.format(format, (Object[]) ex));
        Contacts.add(newContact);
        try {
            Files.write(toOurDataFile, Contacts, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static String format(String format) {
        return format;
    }

    public static void searchByName(AppMethods in) {
        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        String name = in.getString("What Contact would you like view?");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String list = listIterator.next();
            if (list.contains(name)) {
                System.out.println(list);
            }
        }
    }

    public static void deleteContact(AppMethods in) {
        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        String name = in.getString("What Contact would you like to delete?");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String list = listIterator.next();
            if (list.contains(name)) {
                listIterator.remove();
            }
        }
        try {
            Files.write(toOurDataFile, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
