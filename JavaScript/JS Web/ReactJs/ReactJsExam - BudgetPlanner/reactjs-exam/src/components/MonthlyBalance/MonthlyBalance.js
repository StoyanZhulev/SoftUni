import React, { Component } from 'react';
import { getMonthlyBalance, updateMonthlyBalance } from '../../api/remote';
import Expenses from './Expenses';
import { Link } from 'react-router-dom';
import { withRouter } from 'react-router-dom';
import { deleteExpense } from '../../api/remote';




import toastr from 'toastr';

 class MonthlyBalance extends Component {
    constructor(props) {
        super(props);

        this.state = {
            year:'0',
            month: '0',
            budget:'0',
            income:'0',
            expenses: []
        };


        this.onChangeHandler = this.onChangeHandler.bind(this);
        this.onSubmitHandler = this.onSubmitHandler.bind(this);
    }

    componentDidMount() {
        let year = this.props.match.params.year;
        let month = this.props.match.params.month;
        this.setState({
            year: year,
            month: this.getMonthName(month),
        })
        this.getData();
    }



    async remove(id){
        const res = await deleteExpense(id);
        
        if(res.success === false){
            toastr.error(res.messsage);
            return;
        }

        toastr.success('Expense deleted');
        this.getData();
        
  }

    async getData() {
       let year = Number(this.props.match.params.year);
       let month = this.props.match.params.month;
    
       if(isNaN(year)){
        toastr.error('Invalid year');
        return;
       }


       if(month < 1 || month > 12){
           toastr.error('Invalid month');
           return;
       }

       const data = await getMonthlyBalance(year, month);
   
    
       this.setState({
           year: year,
           month: this.getMonthName(month),
           budget: data.budget,
           income: data.income,
           expenses: data.expenses
       })
       
       toastr.success('Monthly data arrived')
       console.log(this.state.expenses);
       
       
    }

    getMonthNum(month){
        switch(month){
            case "January":
                 return '1';
            case 'February':
                 return '2';
            case 'March':
                 return '3';
            case 'April': 
                return '4';
            case 'May':
                return '5';
            case 'June':
                return '6';
            case 'July':
                return '7';
            case 'August': 
                return '8';
            case 'September':
                return '9';
            case 'October':
                return '10';
            case 'November': 
                return '11';
            case '12':
                return '12';
            default:
            return month;
        }
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
             return num;
        }
    }
    onChangeHandler(e) {
        this.setState({ [e.target.name]: e.target.value });
    }


    async onSubmitHandler(e){
        e.preventDefault();

        const res = await updateMonthlyBalance(this.state.year, this.getMonthNum(this.state.month), this.state.income, this.state.budget);
 
        toastr.success(res.message);
        this.getData();
    }

    render() {

        return (
            <div className="container">
  <div className="row space-top">
    <div className="col-md-12">
      <h1>Welcome to Budget Planner</h1>
    </div>
  </div>

    <div className="row space-top ">
      <div className="col-md-12 ">
        <div className="card bg-secondary">
          <div className="card-body">
            <blockquote className="card-blockquote">
              <h2 id="month">{this.state.month} {this.state.year}</h2>
              <div className="row">
                <div className="col-md-3 space-top">
                  <h4>Planner</h4>
                  <form onSubmit={this.onSubmitHandler}>
                    <div className="form-group">
                      <label className="form-control-label" htmlFor="income">Income:</label>
                      <input className="form-control" name="income" onChange={this.onChangeHandler} value={this.state.income} type="number" />
                    </div>
                    <div className="form-group">
                      <label className="form-control-label" htmlFor="budget">Budget:</label>
                      <input className="form-control" name="budget" onChange={this.onChangeHandler}  value={this.state.budget} type="number" />
                    </div>
                    <input type="submit" className="btn btn-secondary" defaultValue="Save" />
                  </form>
                </div>
                <div className="col-md-8 space-top">
                  <div className="row">
                    <h4 className="col-md-9">Expenses</h4>
                

                    <Link to={ { pathname:`/plan/${this.state.year}/${this.getMonthNum(this.state.month)}/expense`}}>Add expenses</Link>
                  </div>
                  <table className="table">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Cost</th>
                        <th>Payment Date</th>
                        <th />
                      </tr>
                    </thead>
                    <tbody>
                      {this.state.expenses.map(e => {
                          
                        let date = e.date + '-' + e.month + '-' + e.year;
                      return <Expenses key={e.id} id={e.id} remove={() => this.remove(e.id)} name= {e.name}  category={e.category} date={date} cost={e.amount} />
                      
                      })}
                    </tbody>
                  </table>
                </div>
              </div>
            </blockquote>
          </div>
        </div>
      </div>
      </div>
</div>

        );
    }
}

export default withRouter(MonthlyBalance)