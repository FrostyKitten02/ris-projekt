package ris.ekipa5.demo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjektSearch {
    private String searchString;
    private Integer minZaposelenih;
    private Boolean imaOdgovornega;
    private Integer minDelovnihNalogov;
}
