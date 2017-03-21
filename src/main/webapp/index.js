var myModule = angular.module("HelloAngular" ,[]);

myModule.controller("helloAngular",[
    function HelloAngular(){
        var self = this;
        self.notes = [
            {
                id:1,
                label: 'First Node',
                done: false
            },
            {
                id:2,
                label: 'Second Note',
                done: false
            },
            {
                id:3,
                label: 'Finished Third Note',
                done: true
            }
        ];

    }
]);