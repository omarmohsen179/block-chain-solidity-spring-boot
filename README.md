
# Coffee Supply Chain Blockchain Application

## Overview
This project is designed to demonstrate the integration of a Java Spring Boot application with Ethereum blockchain using Web3j for a coffee supply chain scenario. It utilizes Solidity smart contracts to track the movement of coffee batches through various stages from production to consumption, ensuring transparency and immutability of the supply chain data.

## Features

- **Record Transactions**: Record the transfer of coffee batches through different stages of the supply chain on the Ethereum blockchain.
- **Query Batch Information**: Retrieve the current owner and transaction history of a coffee batch.
- **Blockchain Integration**: Leverages Ethereum blockchain for secure and transparent record-keeping.

## Prerequisites

- JDK 11 or newer for running Spring Boot application.
- An Ethereum node access (local or remote, e.g., via Infura).
- Solidity compiler (`solc`) for compiling the smart contracts.
- An Ethereum wallet with Ether for deploying contracts and performing transactions.

## Setup and Installation

### 1. Clone the Project

```bash
git clone https://github.com/yourusername/coffee-supply-chain-blockchain.git
cd coffee-supply-chain-blockchain
```

### 2. Compile Solidity Smart Contracts

Navigate to your Solidity contracts directory and compile them to generate ABI and bytecode.

```bash
solc CoffeeBatchTransfer.sol --bin --abi --optimize
```

### 3. Generate Java Contract Wrappers

Use the Web3j Gradle plugin to generate Java wrappers for your Solidity contracts. Ensure your `build.gradle` is properly configured as described in the project setup instructions.

### 4. Configure Application Properties

Edit `src/main/resources/application.properties` to include your Ethereum node URL and wallet credentials:

```properties
ethereum.rpcUrl=http://localhost:8545
wallet.privateKey=YOUR_PRIVATE_KEY_HERE
```

### 5. Run the Spring Boot Application

Execute the following command in your terminal:

```bash
./gradlew bootRun
```

This starts the Spring Boot application, which interfaces with the Ethereum blockchain through Web3j and the deployed smart contracts.

## Usage

- **Record a Batch Transfer**: Send a POST request to `/api/batches/transfer` with the batch ID and new owner's address.
- **Get Batch Information**: Send a GET request to `/api/batches/{batchId}` to retrieve the current owner and the transaction history.

## Contributing

Contributions are welcome. Please fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
