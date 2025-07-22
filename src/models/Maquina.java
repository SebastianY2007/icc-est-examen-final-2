package models;

import java.lang.classfile.instruction.DiscontinuedInstruction.RetInstruction;
import java.util.*;

public class Maquina implements Comparable<Maquina>{
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }

    private int calcularSubred(){
        return  Integer.parseInt(ip.split("\\")[2]);
    }

    private int calcularRiesgo(){
        int sumaCodigos = 0;
        for (Integer codigo : this.codigos){
            if (codigo % 5 == 0){
                sumaCodigos += codigo;
            }
        }

        String nombreSinEspacios = this.nombre.replace(" ", "");
        Set<Character> caracteresUnidos = new HashSet<>();
        for (char c : nombreSinEspacios.toCharArray()){
            caracteresUnidos.add(c);
        }
        int numCaracteresUnidos = caracteresUnidos.size();
        return sumaCodigos * numCaracteresUnidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }

    public int getSubred() {
        return subred;
    }

    public void setSubred(int subred) {
        this.subred = subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public int compareTo(Maquina otra) {
        int comparacionPorSubred = Integer.compare(otra.getSubred(), this.getSubred());
        if (comparacionPorSubred != 0){
            return comparacionPorSubred;
        }
        return this.getNombre().compareTo(otra.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getSubred());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != getClass()) return false;

        Maquina maquina = (Maquina) o;
        return getSubred() == maquina.getSubred() && Objects.equals(getNombre(), maquina.getNombre());
    }

    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + 
        ", ip=" + ip + 
        ", codigos=" + codigos + 
        ", subred=" + subred + 
        ", riesgo=" + riesgo + "]";
    }

    
}
