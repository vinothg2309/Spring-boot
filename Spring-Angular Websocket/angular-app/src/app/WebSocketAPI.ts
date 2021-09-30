import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import {AppComponent} from './app.component'

export class WebSocketAPI{

    appComponent:AppComponent;
    webSocketEndpoint: string = 'http://localhost:9000/ws';
    topic: string = "/topic/greetings";
    stompClient: any;

    constructor(private app:AppComponent){
        this.appComponent = app;
    }

    _connect(){
        console.log("Initialize WebSocket Connection");
        let ws = new SockJS(this.webSocketEndpoint);
        this.stompClient = Stomp.over(ws)
        const _this = this;
        _this.stompClient.connect({}, function(frame){
            _this.stompClient.subscribe(_this.topic, function(sdkEvent){
                _this._onMessageReceived(sdkEvent);
            })
        }, this._errorCallBack);
    }

    _disconnect() {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    // on error, schedule a reconnection attempt
    _errorCallBack(error) {
        console.log("errorCallBack -> " + error)
        setTimeout(() => {
            this._connect();
        }, 5000);
    }

    /**
  * Send message to sever via web socket
  * @param {*} message 
  */
    _send(message) {
        console.log("calling logout api via web socket");
        this.stompClient.send("/app/hello", {}, JSON.stringify(message));
    }

    _onMessageReceived(message) {
        console.log("Message Recieved from Server :: " + message);
        this.appComponent.handleMessage(JSON.stringify(message.body));
    }


}