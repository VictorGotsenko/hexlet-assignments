// BEGIN
package exercise.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePage {
    private String flash;

    public void setFlash(String flash) {
        this.flash = flash;
    }
}
// END
