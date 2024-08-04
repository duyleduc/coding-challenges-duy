import React from 'react';
import './App.css';
import QuizComponent from './QuizComponent';

const App: React.FC = () => {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Quiz Application</h1>
                <QuizComponent />
            </header>
        </div>
    );
}

export default App;
