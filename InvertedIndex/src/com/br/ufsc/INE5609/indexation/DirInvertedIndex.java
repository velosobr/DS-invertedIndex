package com.br.ufsc.INE5609.indexation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirInvertedIndex {
    private HashMap<String, List<Integer>> dir;

    public DirInvertedIndex(HashMap<String, List<Integer>> dir) {
        this.dir = dir;
    }


    public void insert(String key, int index) {
        if (dir.containsKey(key))
            dir.get(key).add(index);
        else {
            dir.put(key, new ArrayList<>());
            dir.get(key).add(index);
        }
    }

    /**
     * @param Key - parametro responsavel por filtrar qual lista retornar
     * @return - retorna uma lista baseada na chave
     */
    public List<Integer> getList(String Key) {
        return dir.get(Key);
    }
}