package harvester.entrypoint

import java.util.UUID
import io.grpc.stub.StreamObserver
import io.grpc.Channel
import Scynet.ComponentGrpc.ComponentImplBase
import Scynet.HatcheryGrpc
import Scynet.ComponentOuterClass.*
import Scynet.HatcheryOuterClass.*
import Scynet.Shared.*

class ComponentService(public val hatcheryChannel: Channel, public val address: String, agents: List<Agent>): ComponentImplBase() {
    public val uuid = UUID.randomUUID().toString()
    public val runnerType = "scynet-ethereum-harvester"
    public val agents = agents.map({ it.toBuilder()
        .setComponentType(runnerType)
        .setComponentId(uuid)
        .build()
    })

    public fun register() {
        val hatcheryBlocking = HatcheryGrpc.newBlockingStub(hatcheryChannel)
        hatcheryBlocking.registerComponent(ComponentRegisterRequest.newBuilder()
            .setUuid(uuid)
            .setAddress(address)
            .addRunnerType(runnerType)
            .build())

        for (agent in agents) {
            hatcheryBlocking.registerAgent(AgentRegisterRequest.newBuilder()
                .setAgent(agent)
                .build())
        }
    }

    private fun hasAgent(id: String): Boolean {
        return agents.any({ a -> a.uuid == id })
    }
    override fun registerInput(request: RegisterInputRequest, responseObserver: StreamObserver<Void>) {
        responseObserver.onNext(Void.newBuilder().build())
        responseObserver.onCompleted()
    }
    override fun agentStart(request: AgentStartRequest, responseObserver: StreamObserver<Void>) {
        responseObserver.onNext(Void.newBuilder().build())
        responseObserver.onCompleted()
        if (!hasAgent(request.egg.uuid)) {
            val hatcheryFuture = HatcheryGrpc.newFutureStub(hatcheryChannel)
            hatcheryFuture.agentStopped(AgentStoppedEvent.newBuilder()
                .setAgent(request.egg)
                .setResaon("Nonexistent agent")
                .setCode(404)
                .build())
        }
    }
    override fun agentStop(request: AgentRequest, responseObserver: StreamObserver<Void>) {
        responseObserver.onNext(Void.newBuilder().build())
        responseObserver.onCompleted()
    }
    override fun agentStatus(request: AgentRequest, responseObserver: StreamObserver<AgentStatusResponse>) {
        responseObserver.onNext(AgentStatusResponse.newBuilder().setRunning(hasAgent(request.uuid)).build())
        responseObserver.onCompleted()
    }
    override fun agentList(request: AgentQuery, responseObserver: StreamObserver<ListOfAgents>) {
        responseObserver.onNext(ListOfAgents.newBuilder().addAllAgents(agents).build())
        responseObserver.onCompleted()
    }
}
