package BDProjeto;

import BDProjeto.util.JsfUtil;
import BDProjeto.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("moveBancoController")
@SessionScoped
public class MoveBancoController implements Serializable {

    @EJB
    private BDProjeto.MoveBancoFacade ejbFacade;
    private List<MoveBanco> items = null;
    private MoveBanco selected;

    public MoveBancoController() {
    }

    public MoveBanco getSelected() {
        return selected;
    }

    public void setSelected(MoveBanco selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setMoveBancoPK(new BDProjeto.MoveBancoPK());
    }

    private MoveBancoFacade getFacade() {
        return ejbFacade;
    }

    public MoveBanco prepareCreate() {
        selected = new MoveBanco();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MoveBancoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MoveBancoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MoveBancoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<MoveBanco> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public MoveBanco getMoveBanco(BDProjeto.MoveBancoPK id) {
        return getFacade().find(id);
    }

    public List<MoveBanco> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<MoveBanco> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = MoveBanco.class)
    public static class MoveBancoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MoveBancoController controller = (MoveBancoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "moveBancoController");
            return controller.getMoveBanco(getKey(value));
        }

        BDProjeto.MoveBancoPK getKey(String value) {
            BDProjeto.MoveBancoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new BDProjeto.MoveBancoPK();
            key.setFkCodBanco(Long.parseLong(values[0]));
            key.setDtDataEntrada(java.sql.Date.valueOf(values[1]));
            key.setCodSeqMove(Long.parseLong(values[2]));
            return key;
        }

        String getStringKey(BDProjeto.MoveBancoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getFkCodBanco());
            sb.append(SEPARATOR);
            sb.append(value.getDtDataEntrada());
            sb.append(SEPARATOR);
            sb.append(value.getCodSeqMove());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof MoveBanco) {
                MoveBanco o = (MoveBanco) object;
                return getStringKey(o.getMoveBancoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), MoveBanco.class.getName()});
                return null;
            }
        }

    }

}
