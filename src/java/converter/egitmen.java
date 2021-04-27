/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.egitmenDao;
import entity.Egitmen;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Casper
 */
@FacesConverter(value="egitmen")
public class egitmen implements Converter{
    private egitmenDao egitmenDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getEgitmenDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Egitmen e=(Egitmen) arg2;
        return e.getId_egitmen().toString();
    }

    public egitmenDao getEgitmenDao() {
        if (this.egitmenDao==null){
            this.egitmenDao=new egitmenDao();
            
        }
        return egitmenDao;
    }
    
}
