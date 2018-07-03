Vue.component('message-row', {
    props: ['message'],
    template: '<div><i>({{message.id}})</i>{{ message.text }}</div>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template: '<div><message-row v-for="message in messages" :message="message" /></div>'
});
var app = new Vue({
    el: '#app',
    template:'<messages-list :messages="messages" />',
    data: {
        messages: [
            {id:'1', text: 'Wow'},
            {id:'2', text: 'Wo'},
            {id:'3', text: 'W'},
        ]
    }
})