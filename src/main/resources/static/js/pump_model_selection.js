var messageApi = Vue.resource('/pump-selection');

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

// Vue.component('message-form', {
//     props:['messages'],
//     data: function(){
//         return{
//             text: 'test'
//         }
//     },
//     template:
//     '<div>' +
//     // '<input type="text" placeholder = "Type your new message" v-model="text"/>' +
//     '<a href="#" class="button7" @click = "save">Рассчитать</a>'+
//     '<div/>',
//     methods: {
//         save: function(){
//
//             var unit_type_selected = document.getElementById("unit_type").value;
//             var u_type = unit_type_selected.valueOf();
//             var message = {text : u_type};
//
//             messageApi.save({},message).then(result =>
//                 result.json().then(data =>{
//                     this.messages.push(data);
//                     alert(data);
//                 })
//             )
//             draw();
//         }
//     }
// });

// Vue.js framework main object
var model_selector = new Vue({
    el: '#model_selector',
    // data: {
    //     message: 'Hello!'
    // }
    template:'<messages-list :messages="messages" />',
    data: {
        messages: []
    }
})

// var data_input = new Vue({
//     el: '#data_input',
//     // data: {
//     //     message: 'Hello!'
//     // }
//     template:'<message-form :messages="messages" />',
//     data: {
//         messages: []
//     }
// })
