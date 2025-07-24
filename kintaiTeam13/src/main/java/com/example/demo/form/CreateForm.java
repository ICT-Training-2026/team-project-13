package com.example.demo.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateForm {

    @NotNull(message = "入力してください。")
    @Min(value = 100000, message = "社員IDは6桁の数値で入力してください。") // 例: 100000 から 999999 の範囲を指定
    @Max(value = 999999, message = "社員IDは6桁の数値で入力してください。")
    private Integer employeeId;

    @NotBlank(message = "入力してください。")
    @Size(max = 50, message = "名前は50文字以内で入力してください。")
    private String name;

    @NotNull(message = "入力してください。")
    /*@Min(value = 1000, message = "部署IDは4桁の数値で入力してください。") // 例: 1000 から 9999 の範囲を指定
    @Max(value = 9999)*/
    private Integer departmentId;

    @NotBlank(message = "入力してください。")
    @Size(max = 16, message = "パスワードは16文字以下で入力してください。")
    private String pass;
    
    @NotBlank(message = "選択してください。")
    private String authority;

}
