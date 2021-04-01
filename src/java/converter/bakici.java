/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.bakiciDao;
import entity.Bakici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Casper
 */
@FacesConverter(value="bakici")
public class bakici implements Converter{
    private bakiciDao bakiciDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getBakiciDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Bakici b=(Bakici) arg2;
        return b.getId_bakici().toString();
    }

    public bakiciDao getBakiciDao() {
        if(this.bakiciDao==null){
            this.bakiciDao=new bakiciDao();
            
        }
        return bakiciDao;
    }
    
}
