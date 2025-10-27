/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Acer
 */
public class DadosAdicionais {
    private boolean fuma;
    private boolean bebe;
    private boolean colesterol;
    private boolean diabete;
    private boolean doencaCardiaca;
    private List<String> cirurgias;
    private List<String> alergias;

    public DadosAdicionais() {
    }

    public DadosAdicionais(boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List cirurgias, List alergias) {
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }

    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean isColesterol() {
        return colesterol;
    }

    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public List getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List getAlergias() {
        return alergias;
    }

    public void setAlergias(List alergias) {
        this.alergias = alergias;
    }
    
    
}
