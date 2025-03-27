package com.example.library.domain.req;

import com.example.library.domain.base.BaseReq;
import lombok.Data;

@Data
public class LibBorrowListReq extends BaseReq {
    String status;
    String username;
}
