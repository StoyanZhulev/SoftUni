import React, { Component } from 'react';
import Month from './Month';

export default class MonthsList extends Component {
constructor(props){
    super(props)
}
    getMonthName(num){
        switch(num){
            case "1":
                 return 'January';
            case '2':
                 return 'February';
            case '3':
                 return 'March';
            case '4': 
                return 'April';
            case '5':
                return 'May';
            case '6':
                return 'June';
            case '7':
                return 'July';
            case '8': 
                return 'August';
            case '9':
                return 'September';
            case '10':
                return 'October';
            case '11': 
                return 'November';
            case '12':
                return 'December';
            default:
            break;
        }
    }
    render() {
        return (
            <div>
                {Array.from(Object.keys(this.props.months)).map(key => (
                    <Month
                        month={this.getMonthName(key)}
                        budget={this.props.months[key].budget}
                        balance={this.props.months[key].balance}
                        year={this.props.year}
                      /> 
                ))}
            </div>
        );
    }
}