package Model;

import DAO.ItemPadraoFrigobarDAO;
import java.sql.SQLException;
import java.util.List;

public class ItemPadraoFrigobar {

    private int quantidade;
    private ItemConsumo item;
    private int idItemConsumo;

    public ItemPadraoFrigobar(int quantidade, ItemConsumo item) {
        this.quantidade = quantidade;
        this.item = item;
    }

        public static ItemPadraoFrigobar obterItemPadraoFrigobar(int codItem) throws ClassNotFoundException, SQLException{
        return ItemPadraoFrigobarDAO.obterItensPadraoFrigobar(codItem);
    }
    
    public static List<ItemPadraoFrigobar> obterItensPadraoFrigobar() throws ClassNotFoundException, SQLException{
        return ItemPadraoFrigobarDAO.obterItensPadraoFrigobar();
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemConsumo getItem() throws ClassNotFoundException, SQLException {
        if((this.idItemConsumo != 0) && (this.item == null)){
            this.item = ItemConsumo.obterItemConsumo(this.idItemConsumo);
        }
      
        return item;
    }

    public void setItem(ItemConsumo item) {
        this.item = item;
    }

    public int getIdItemConsumo() {
        return idItemConsumo;
    }

    public void setIdItemConsumo(int idItemConsumo) {
        this.idItemConsumo = idItemConsumo;
    }

}