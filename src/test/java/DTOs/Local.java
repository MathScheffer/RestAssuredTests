package DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

@Builder

@NoArgsConstructor
@AllArgsConstructor
public class Local {
    @Nullable
    private int id;
    private String nome;
    private String tag_local;
}
