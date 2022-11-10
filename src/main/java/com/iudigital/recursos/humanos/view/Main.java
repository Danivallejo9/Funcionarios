package com.iudigital.recursos.humanos.view;

import com.iudigital.controller.FuncionariosController;
import com.iudigital.dominio.Funcionarios;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
        
        public static void crearFuncionario(FuncionariosController funcionariosController ) {
            try {
               Scanner sc = new Scanner(System.in);
               
               System.out.println("Digite su número de documento");
               String IdDoc = sc.nextLine();
               System.out.println("Su documento es: " + IdDoc);
               System.out.println("--------------------");
                
               System.out.println("Digite su tipo de documento");
               String tipodoc = sc.nextLine();
               System.out.println("Su nombre es: " + tipodoc);
               System.out.println("--------------------");
               
               System.out.println("Digite su nombre");
               String nombre = sc.nextLine();
               System.out.println("Su nombre es: " + nombre);
               System.out.println("--------------------");
                
               System.out.println("Digite sus apellidos");
               String apellidos = sc.nextLine();
               System.out.println("Sus apellidos son: " + apellidos);
               System.out.println("--------------------");
               
               System.out.println("Digite su estado civil");
               String estadocivil = sc.nextLine();
               System.out.println("Su estado civil es: " + estadocivil);
               System.out.println("--------------------");
               
               System.out.println("Digite su sexo");
               String sexo = sc.nextLine();
               System.out.println("Su sexo es: " + sexo);
               System.out.println("--------------------");
               
               System.out.println("Digite su dirección");
               String direccion = sc.nextLine();
               System.out.println("Su dirección es: " + direccion);
               System.out.println("--------------------");
               
               System.out.println("Digite su teléfono");
               String telefono = sc.nextLine();
               System.out.println("Su teléfono es: " + telefono);
               System.out.println("--------------------");
               
               System.out.println("Digite su fecha de nacimiento");
               String fechanac = sc.nextLine();
               System.out.println("Su fecha de nacimiento es: " + fechanac);
               Date fecha = Date.valueOf(fechanac);
               System.out.println("--------------------");
               
               Funcionarios funcionarios = new Funcionarios();
               funcionarios.setIddoc(Integer.parseInt(IdDoc));
               funcionarios.setTipodoc(tipodoc);
               funcionarios.setNombre(nombre);
               funcionarios.setApellidos(apellidos);
               funcionarios.setEstadocivil(estadocivil);
               funcionarios.setSexo(sexo);
               funcionarios.setDireccion(direccion);
               funcionarios.setTelefono(telefono);
               funcionarios.setFechanac(fecha);
               System.out.println("funcionario:" +  funcionarios);
               funcionariosController.crearFuncionario(funcionarios);
               System.out.println("El funcionario se ha creado con éxito");
               
               
            } catch (SQLException ex) {
                ex.printStackTrace();
            }           
        }
        
        public static void obtenerFuncionarios(FuncionariosController funcionariosController) {
            try {
                
                List<Funcionarios> funcionarios = funcionariosController.obtenerFuncionarios();
                if (funcionarios.isEmpty()) {
                    System.out.println("No hay datos");
                } else 
                {
                    funcionarios.forEach(funcionario -> {
                        System.out.println("iddoc: " + funcionario.getIddoc());
                        System.out.println("tipodoc: " + funcionario.getTipodoc());
                        System.out.println("nombre: " + funcionario.getNombre());
                        System.out.println("apellidos: " + funcionario.getApellidos());
                        System.out.println("estadocivil: " + funcionario.getEstadocivil());
                        System.out.println("sexo: " + funcionario.getSexo());
                        System.out.println("direccion: " + funcionario.getDireccion());
                        System.out.println("telefono: " + funcionario.getTelefono());
                        System.out.println("fechanac: " + funcionario.getFechanac());
                        System.out.println("-----------------------");
                    });       
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        public static void obtenerFuncionario(FuncionariosController funcionariosController) {
            try {
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Digite el id del funcionario: ");
                int iddoc = sc.nextInt();
                System.out.println("id: " + iddoc);
                System.out.println("------------------------");
                
                Funcionarios funcionario = funcionariosController.obtenerFuncionario(iddoc);
                System.out.println("Listar funcionario = " + funcionario);
                System.out.println("-------------------------");
                                                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        public static void actualizarFuncionario(FuncionariosController funcionariosController) {
            try {
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Digite el id del funcionario: ");
                int iddoc = sc.nextInt();
                sc.nextLine();
                System.out.println("El id es: " + iddoc);
                Funcionarios funcionarioExits = funcionariosController.obtenerFuncionario(iddoc);
                if(funcionarioExits == null) {
                    System.out.println("No existe el funcionario");
                    return;
                }
                
               System.out.println("Digite su número de documento");
               int IdDoc = sc.nextInt();
               System.out.println("Su documento es: " + IdDoc);
               System.out.println("--------------------");
                
               System.out.println("Digite su tipo de document");
               String tipodoc = sc.nextLine();
               System.out.println("Su nombre es: " + tipodoc);
               System.out.println("--------------------");
               
               System.out.println("Digite su nombre");
               String nombre = sc.nextLine();
               System.out.println("Su nombre es: " + nombre);
               System.out.println("--------------------");
                
               System.out.println("Digite sus apellidos");
               String apellidos = sc.nextLine();
               System.out.println("Sus apellidos son: " + apellidos);
               System.out.println("--------------------");
               
               System.out.println("Digite su estado civil");
               String estadocivil = sc.nextLine();
               System.out.println("Su estado civil es: " + estadocivil);
               System.out.println("--------------------");
               
               System.out.println("Digite su sexo");
               String sexo = sc.nextLine();
               System.out.println("Su sexo es: " + sexo);
               System.out.println("--------------------");
               
               System.out.println("Digite su dirección");
               String direccion = sc.nextLine();
               System.out.println("Su dirección es: " + direccion);
               System.out.println("--------------------");
               
               System.out.println("Digite su teléfono");
               String telefono = sc.nextLine();
               System.out.println("Su teléfono es: " + telefono);
               System.out.println("--------------------");
               
               System.out.println("Digite su fecha de nacimiento");
               String fechanac = sc.nextLine();
               System.out.println("Su fecha de nacimiento es: " + fechanac);
               Date fecha = Date.valueOf(fechanac); 
               System.out.println("--------------------");
               
               Funcionarios funcionarios = new Funcionarios();
               funcionarios.setIddoc(IdDoc);
               funcionarios.setTipodoc(tipodoc);
               funcionarios.setNombre(nombre);
               funcionarios.setApellidos(apellidos);
               funcionarios.setEstadocivil(estadocivil);
               funcionarios.setSexo(sexo);
               funcionarios.setDireccion(direccion);
               funcionarios.setTelefono(telefono);
               funcionarios.setFechanac(fecha);
               funcionariosController.actualizarFuncionario(IdDoc, funcionarios);
               System.out.println("El funcionario se ha actualizado con éxito");
                
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        public static void eliminarFuncionario(FuncionariosController funcionariosController) {
            try {
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Digite id del funcionario: ");
                int iddoc = sc.nextInt();
                System.out.println("El id del funcionario es "+ iddoc);
                Funcionarios funcionarioExits = funcionariosController.obtenerFuncionario(iddoc);
                if(funcionarioExits == null) {
                    System.out.println("No existe funcionario");
                    return;
                }
                
                funcionariosController.eliminarFuncionario(iddoc);
                System.out.println("Funcionario eliminado");
                obtenerFuncionarios(funcionariosController);
                
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        public static void main(String[] arges) {
            FuncionariosController funcionariosController = new FuncionariosController();
            //crearFuncionario(funcionariosController);
            //obtenerFuncionarios(funcionariosController);
            //obtenerFuncionario(funcionariosController);
            //actualizarFuncionario(funcionariosController);
            //eliminarFuncionario(funcionariosController);
            
            var opcion = -1;
            var Scanner = new Scanner(System.in);
            while(opcion != 0) {
                System.out.println("---------------------");
                System.out.println("Elegir opción");
                System.out.println("---------------------");
                
                System.out.println("1. Crear Funcionarios");
                System.out.println("2. Listar Funcionarios");
                System.out.println("3. Listar por Id");
                System.out.println("4. Editar Funcionario");
                System.out.println("5. Eliminar Funcionarios");
                
                System.out.println("---------------------");
                
                opcion = Integer.parseInt(Scanner.nextLine());
                switch(opcion) {
                    case 0:
                        System.out.println("Ha salido de la aplicación");
                        break;
                    case 1:
                        crearFuncionario(funcionariosController);
                        break;
                    case 2:
                        obtenerFuncionarios(funcionariosController);
                        break;
                    case 3:
                        obtenerFuncionario(funcionariosController);
                        break;
                    case 4:
                        actualizarFuncionario(funcionariosController);
                        break;
                    case 5:
                        eliminarFuncionario(funcionariosController);
                        
            }
            }
        }
    }
    

