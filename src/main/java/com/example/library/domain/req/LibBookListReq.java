package com.example.library.domain.req;

import com.example.library.domain.base.BaseReq;
import lombok.Data;

@Data
public class LibBookListReq extends BaseReq {
    String name;
    String author;
    String category;
}
