// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract CoffeeBatchTransfer {
    struct Batch {
        string batchId;
        address currentOwner;
    }

    event TransferRecorded(string batchId, address indexed from, address indexed to);

    mapping(string => Batch) public batches;

    // Record a new batch or transfer ownership of an existing batch
    function recordTransfer(string memory batchId, address to) public {
        require(to != address(0), "Invalid address");

        Batch storage batch = batches[batchId];
        require(batch.currentOwner == address(0) || batch.currentOwner == msg.sender, "Not the owner");

        emit TransferRecorded(batchId, batch.currentOwner, to);

        batch.batchId = batchId;
        batch.currentOwner = to;
        batches[batchId] = batch;
    }

    // Retrieve the current owner of a batch
    function getCurrentOwner(string memory batchId) public view returns (address) {
        return batches[batchId].currentOwner;
    }
}