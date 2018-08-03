var messageApi = Vue.resource('/message');

Vue.component('message-row', {
    props: ['message'],
    template:'<div>Модель подобранного узла:{{message.text}}</div>'
});

Vue.component('messages-list',{
    props:['messages'],
    template:
    '<div>' +
    '<message-row v-for ="message in messages" :message = "message"/> '+
    '</div>',
    created: function () {
        messageApi.get().then(result =>
            result.json().then(data => data.forEach(message => this.messages.push(message))))
    }
})

// Vue.js framework main object
var model_selector_app = new Vue({
    el: '#model_selector_app',
    // data: {
    //     message: 'Hello!'
    // }
    template:'<messages-list :messages="messages" />',
    data: {
        messages: []
    }
})

