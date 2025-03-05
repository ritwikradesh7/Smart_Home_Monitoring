import React from 'react'
import ProjectStatistics from '../components/ProjectStatistics'
import Platforms from '../components/Platforms'
import ProjectCard from '../components/ProjectCard';
import ClientCard from '../components/ClientCard';
import MemberCard from '../components/MemberCard';
import BarGraph from '../components/bargraph';


const projects = [
  {
    name: "Website Redesign",
    type: "Web Development",
    date: "2024-03-15",
    members: ["Alice", "Bob", "Charlie"],
    files: 4,
    progress: 20,
  },
  {
    name: "Mobile App Launch",
    type: "Mobile Development",
    date: "2024-04-10",
    members: ["David", "Emma", "Frank"],
    files: 6,
    progress: 45,
  },
  {
    name: "AI Chatbot",
    type: "Machine Learning",
    date: "2024-05-05",
    members: ["Grace", "Hannah", "Ian"],
    files: 10,
    progress: 30,
  },
  {
    name: "E-commerce Platform",
    type: "Web Development",
    date: "2024-06-12",
    members: ["Jack", "Katie", "Liam"],
    files: 8,
    progress: 60,
  }
  
];
const clients = [
  {
    name: "Tech Innovations Ltd.",
    title: "Project Manager",
    date: "2024-05-05T11:15:00Z",
  },
  {
    name: "NextGen Solutions",
    title: "Software Engineer",
    date: "2024-06-12T09:30:00Z",
  },
  {
    name: "Global FinTech Corp.",
    title: "Data Analyst",
    date: "2024-07-22T14:45:00Z",
  },
  {
    name: "AI Pioneers Inc.",
    title: "Machine Learning Engineer",
    date: "2024-08-15T16:00:00Z",
  },
 
];
const members = [
  {
    total_members: 4,
    job: "UI Designer",
  },
  {
    total_members: 6,
    job: "Frontend Developer",
  },
  {
    total_members: 5,
    job: "Backend Engineer",
  },
  {
    total_members: 3,
    job: "Data Scientist",
  },
];







const Home = () => {
  return (
    <div className='p-5'>
      <div className='grid md:grid-cols-2 xl:grid-cols-4 gap-4'>
        <ProjectStatistics/>
        <Platforms/>
        <BarGraph/>
        <Platforms/> 
      </div>

      <div>
        <div className='flex justify-between items-center py-4'>
          <h1 className='text-lg font-semibold'>Energy Data</h1>
          <p className='text-sm underline text-indigo-600'>See all</p>
        </div>

        <div className='grid md:grid-cols-2 xl:grid-cols-4 gap-8'>
          {
            projects && projects.map((project)=><ProjectCard project={project}/>)
          }
        </div>
      </div>

      <div>
        <div className='flex justify-between items-center py-4'>
          <h1 className='text-lg font-semibold'>Alerts</h1>
          <p className='text-sm underline text-indigo-600'>See all</p>
        </div>

        <div className='grid md:grid-cols-2 xl:grid-cols-4 gap-8'>
          {
            clients && clients.map((client)=><ClientCard client={client}/>)
          }
        </div>
      </div>

      <div>
        <div className='flex justify-between items-center py-4'>
          <h1 className='text-lg font-semibold'>Current Members</h1>
          <p className='text-sm underline text-indigo-600'>See all</p>
        </div>

        <div className='grid md:grid-cols-2 xl:grid-cols-4 gap-8'>
          {
            members && members.map((member)=><MemberCard member={member}/>)
          }
        </div>
      </div>
      
    </div>
  )
}

export default Home