package com.example.blockchain.block;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    private String batchId;
    private String from;
    private String to;
}
