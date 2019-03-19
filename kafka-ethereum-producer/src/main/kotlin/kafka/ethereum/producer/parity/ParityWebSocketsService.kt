package kafka.ethereum.producer.parity

import org.web3j.protocol.parity.Parity
import org.web3j.protocol.websocket.WebSocketClient
import org.web3j.protocol.websocket.WebSocketService
import java.net.URI

class ParityWebSocketsService {

    fun startParity(): Parity {
        val webSocketClient = WebSocketClient(URI("ws://127.0.0.1:8546"))
        val includeRawResponses = false
        val webSocketService = WebSocketService(webSocketClient, includeRawResponses)
        webSocketService.connect()
        return Parity.build(webSocketService)
    }
}