package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Enroll {
    private int year;
    private int semester;
    private String title;
    private String Status;
    private String name;
    private int credit;
}
