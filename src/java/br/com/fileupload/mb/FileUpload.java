
package br.com.fileupload.mb;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

package br.com.nooclix.primeupload.mb;


import java.io.IOException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author Larissa Alves
 */

@ManagedBean(name="arquivoUpload")
@ViewScoped
public class FileUpload {
    private UploadedFile arquivo;
    public String conteudo;

        public String getConteudoDoArquivo() {
            return conteudo;
        }

        public void setConteudoDoArquivo(String conteudo) {
            this.conteudo = conteudo;
        }    
   
     
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Arquivo adicionado com sucesso", event.getFile().getFileName() + " is uploaded.");
     
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        conteudo = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
        System.out.println(conteudo);
    }
    
    
    
}
