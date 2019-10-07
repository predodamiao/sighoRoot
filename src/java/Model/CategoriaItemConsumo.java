package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoriaItemConsumo {
    CAMARARIA("Camararia", 0),
    LAVANDERIA("Lavanderia", 1),
    RESTAURANTE("Restaurante", 2);

    private int id;
    private String nomeCategoria;

    CategoriaItemConsumo(String funcao, int id) {
        this.nomeCategoria = funcao;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public static List<CategoriaItemConsumo> obterCategoriasItemConsumo() {
        ArrayList categorias = new ArrayList<CategoriaItemConsumo>();
        categorias.addAll(Arrays.asList(CategoriaItemConsumo.values()));
        return categorias;
    }

    public static CategoriaItemConsumo obterCategoriaItemConsumo(String valor) {
        return Enum.valueOf(CategoriaItemConsumo.class, valor);
    }

}
