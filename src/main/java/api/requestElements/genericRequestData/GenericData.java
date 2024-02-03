package api.requestElements.genericRequestData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericData {
    @Builder.Default
    private String jsonrpc = "2.0";
    @Builder.Default
    private int id = 1548868037;
    private String method;
}
