package org.geekbang.time.commonmistakes.productionready.health;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId;
    private String userName;
}
