var messageApi = Vue.resource('/pump-selection');

Vue.component('message-form', {
    props:['messages'],
    data: function(){
        return{text: ''}
    },
    template:
    '<div>' +
    // '<input type="text" placeholder = "Type your new message" v-model="text"/>' +
    '<a href="#" class="button7" @click = "save">Рассчитать</a>'+
    '</div>',
    methods: {
        save: function(){
            var unit_type_selected = document.getElementById("unit_type").value.valueOf();
            var unit_flow = document.getElementById("flow").value.valueOf();
            var unit_preslose = document.getElementById("preslose").value.valueOf();
            var result = unit_type_selected + unit_flow + unit_preslose;
            var message = {text : result};
            model_selector.messages = [];
            messageApi.save({},message).then(result =>
                result.json().then(data => {
                    this.messages.push(data)
                }))
            draw();
        }
    }
});


Vue.component('message-row', {
    props: ['message'],
    template:'<div>Модель подобранного узла:{{message.text}}</div>'
});


Vue.component('messages-list',{
    props:['messages'],
    template:
    '<div>' +
        '<message-form :messages="messages" />'+
        '<h4>Результаты подбора</h4>'+
    '<message-row v-for ="message in messages" :message = "message"/> '+
    '</div>',
    created: function  () {
        messageApi.get().then(result =>
            result.json().then(data => data.forEach(message => this.messages.push(message))))
    }
})

// Vue.js framework main object

var model_selector = new Vue({
    el: '#model_selector',
    template:'<messages-list :messages="messages" />',
    data: {
        messages: []
    }
})
