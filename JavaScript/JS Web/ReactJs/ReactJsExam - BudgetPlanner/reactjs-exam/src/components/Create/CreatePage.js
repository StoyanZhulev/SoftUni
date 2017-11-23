import React, { Component } from 'react';
import Input from '../common/Input';
import { getExpenseCreate } from '../../api/remote';
import toastr from 'toastr';



export default class CreatePage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            name: '',
            category: '',
            cost: '',
            paymentDate: ''
            
        };

        this.onChangeHandler = this.onChangeHandler.bind(this);
        this.onSubmitHandler = this.onSubmitHandler.bind(this);
    }


    onChangeHandler(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    async onSubmitHandler(e) {
        e.preventDefault();
        console.log(this.state.cost);
        
        const expense = {
            name: this.state.name,
            category: this.state.category,
            date: Number(this.state.paymentDate),
            amount: Number(this.state.cost),
        }
        
       
        if(expense.category.length < 1){
            toastr.error('Category must be longer!');
            return;
        }
        if(expense.name.length < 1){
            toastr.error('Name must be longer!');
            return;
        }

        if(expense.date < 1 || expense.date > 31){
            toastr.error('Date must be between 1 and 31!');
            return;
        }


       if(expense.amount < 0){
        toastr.error('Cost must be a positive number!');
        return;
       }

       let month = this.props.match.params.month;
       let year = this.props.match.params.year;
  
        
        const res = await getExpenseCreate(Number(year), Number(month), expense);

        if (!res.success) {
           toastr.error(res.message);
           console.log(res.errors);
           
            return;
        }
        toastr.success(res.message);
        this.props.history.push('/plan/2017');
    }

    render() {
        let errors = null;
        if (this.state.error) {
            errors = (
                <div>
                    <h2 className="errorMessage">{this.state.error.message}</h2>
                    {Object.keys(this.state.error.errors).map(k => {
                        return <p key={k}>{this.state.error.errors[k]}</p>;
                    })}
                </div>
            );
        }

        return (

            <div class="container">
            <div class="row space-top">
                <div class="col-md-12">
                    <h1>Add Expenses</h1>
                    <h3>November 2017</h3>
                    {errors}
                </div>
            </div>
            <div class="row space-top">
                <div class="col-md-10">
                    <form onSubmit={this.onSubmitHandler}>
                        <legend>Add a new expense</legend>
                        <div class="form-group">
                            <label class="col-md-2" for="name">Name:</label>
                            <input class="col-md-2" onChange={this.onChangeHandler} name="name" type="text" />
                        </div>
                        <div class="form-group">
                            <label class="col-md-2" for="category">Category:</label>
                            <select onChange={this.onChangeHandler} class="col-md-2 pl-2" name="category">
                                <option>Non-essential</option>
                                <option>Fixed</option>
                                <option>Variable</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2" for="cost">Cost:</label>
                            <input onChange={this.onChangeHandler} class="col-md-2" name="cost" type="number" />
                        </div>
                        <div class="form-group">
                            <label class="col-md-2" for="paymentDate">Payment Date:</label>
                            <input onChange={this.onChangeHandler} class="col-md-2" name="paymentDate" type="number" />
                        </div>
                        <input type="submit" class="btn btn-secondary" value="Add" />
                    </form>
                </div>
            </div>
        </div>
        );
    }
}
