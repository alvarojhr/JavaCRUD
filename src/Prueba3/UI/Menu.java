package Prueba3.UI;

import Prueba3.Core.Models.Contacto;
import Prueba3.Entity.DbConnection;
import Prueba3.Entity.Implementation;

import java.util.Scanner;

public class Menu {
    public static void showMenu(){
        System.out.print("---Gestión de contactos---\n\n" +
                "1. Listar contactos.\n" +
                "2. Registrar contacto.\n" +
                "3. Eliminar contacto.\n" +
                "4. Actualizar contacto.\n" +
                "\n0. Salir\n" +
                "\nDigita una opción válida del menú: ");
    }

    public static void selectOption(int option, Scanner scanner){
        DbConnection.connect();
        switch (option){
            case 1:
                Implementation.readContacts();
                break;
            case 2:
                Contacto contacto = readContactInfo();
                Implementation.createContact(contacto);
                break;
            case 3:
                Implementation.readContacts();
                System.out.print("Digita el id correspondiente al usuario a eliminar: ");
                int id = scanner.nextInt();
                Implementation.deleteContact(id);
                break;
            case 4:
                Implementation.readContacts();
                System.out.print("Digita el id correspondiente al usuario a actualizar: ");
                int idUpd = scanner.nextInt();
                System.out.println("------Datos del contacto "+String.valueOf(idUpd)+"------");
                Implementation.GetContact(idUpd);
                System.out.println("------Actualización de datos del contacto "+String.valueOf(idUpd)+"------");
                Contacto contact = readContactInfo();
                Implementation.updateContact(idUpd,contact);
                break;
            case 0:
                break;
            default:
                break;
        }

    }

    private static Contacto readContactInfo(){
        Scanner scanner = new Scanner(System.in);
        Contacto contacto = new Contacto();

        System.out.print("Nombre: ");
        contacto.nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        contacto.apellido = scanner.nextLine();
        System.out.print("Género: ");
        contacto.genero = scanner.nextLine();
        System.out.print("Tipo de identificación: ");
        contacto.tipoIdentificacion = scanner.nextLine();
        System.out.print("Identificación: ");
        contacto.identificacion = scanner.nextLine();
        System.out.print("Teléfono: ");
        contacto.telefono = scanner.nextLine();
        System.out.print("Dirección: ");
        contacto.direccion = scanner.nextLine();
        System.out.print("E-mail: ");
        contacto.email = scanner.nextLine();

        return  contacto;
    }
}
