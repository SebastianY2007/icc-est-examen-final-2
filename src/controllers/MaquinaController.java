package controllers;

import java.util.*;

import models.Maquina;

public class MaquinaController {
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral){
        Stack<Maquina> resultado = new Stack<>();
        for (Maquina maquina : maquinas){
            resultado.push(maquina);
        }
        return resultado;
    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila){
        Set<Maquina> resultadoOrdenado = new TreeSet<>();
        while (!pila.isEmpty()){
            resultadoOrdenado.add(pila.pop());
        }
        return resultadoOrdenado;
    }

    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas){
        TreeMap<Integer, Queue<Maquina>> mapaPorRiesgo = new TreeMap<>();
        for (Maquina maquina : maquinas){
            int riesgo = maquina.getRiesgo();
            Queue<Maquina> grupo = mapaPorRiesgo.computeIfAbsent(riesgo, k -> new LinkedList<>());
            grupo.add(maquina);
        }
        return mapaPorRiesgo;
    }
    
    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa){
        Queue<Maquina> grupoSeleccionado = null;
        int tamanioMaximo = -1;
        for (Map.Entry<Integer, Queue<Maquina>> entry : mapa.entrySet()){
            Queue<Maquina> grupoActual = entry.getValue();
            int tamanioActual = grupoActual.size();
            if (tamanioActual >= tamanioMaximo){
                tamanioMaximo = tamanioActual;
                grupoSeleccionado = grupoActual;
            }
        }

        Stack<Maquina> resultado = new Stack<>();
        if (grupoSeleccionado != null){
            for (Maquina maquina : grupoSeleccionado){
                resultado.push(maquina);
            }
        }
        return resultado;
    }
}
